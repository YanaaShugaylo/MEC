package pro.midev.mec.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pro.midev.mec.events.EventType
import pro.midev.mec.events.Events

abstract class BaseViewModel<S : BaseState, E : BaseEvent, A : BaseAction>(
    initialState: S
) : ViewModel(), ScreenModel, EventHandler<S, E, A> {

    private val _viewState = MutableStateFlow(initialState)
    private val _action = MutableSharedFlow<A>(replay = 0)

    // TODO: Убрать когда в Voyager завезут screen result api
    protected val eventsScope = CoroutineScope(Dispatchers.IO)

    protected var viewState: S
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }

    protected var action: A? = null
        set(value) {
            viewModelScope.launch {
                if (value != null) {
                    _action.emit(value)
                } else {
                    _action.resetReplayCache()
                }
            }
        }

    override val viewStates: StateFlow<S>
        get() = _viewState.asStateFlow()
    override val viewActions: SharedFlow<A>
        get() = _action.asSharedFlow()

    protected inline fun <reified T : EventType> subscribeEvent(
        crossinline action: (event: T) -> Unit
    ) {
        eventsScope.launch {
            Events.subscribe<T> { event ->
                action(event)
            }
        }
    }

    protected fun publishEvent(type: EventType) {
        eventsScope.launch {
            Events.publish(type)
        }
    }

    protected fun showErrorToast(ex: Exception) {
        publishEvent(EventType.ShowErrorToast(ex))
    }

    protected fun showTextToast(text: String) {
        publishEvent(EventType.ShowTextToast(text))
    }

    // TODO: Убрать когда в Voyager завезут screen result api
    fun cancelEventsScope() {
        eventsScope.coroutineContext.cancelChildren()
    }

}
