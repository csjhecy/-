package com.csj.lovevideo.utils

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 设置自动清除数据
 */
class AutoClearedValue<T : Any>(activity: AppCompatActivity) : ReadWriteProperty<AppCompatActivity, T> {

    private var mValue: T? = null

    init {
        activity.lifecycle.addObserver(object : LifecycleObserver {

            @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
            fun onDestory() {
                mValue = null
            }
        })
    }

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        return mValue ?: throw IllegalStateException(
            "should never call auto-cleared-value get when it might not be available"
        )
    }

    override fun setValue(thisRef: AppCompatActivity, property: KProperty<*>, value: T) {
        mValue = value
    }
}

class AutoClearedValueForFragment<K : Any>(fragment: Fragment) : ReadWriteProperty<Fragment, K> {
    private var mValue: K? = null

    init {
        fragment.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
            fun onDestory() {
                mValue = null
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): K {
        return mValue ?: throw IllegalStateException(
            "should never call auto-cleared-value get when it might not be available"
        )
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: K) {
        mValue = value
    }

}

class AutoClearedValueForViewGroup<V : Any>(viewGroup: ViewGroup) : ReadWriteProperty<ViewGroup, V> {
    private var mValue: V? = null

    init {
        viewGroup.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewDetachedFromWindow(v: View?) {
                mValue = null
            }

            override fun onViewAttachedToWindow(v: View?) {
            }

        })
    }

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): V {
        return mValue ?: throw IllegalStateException(
            "should never call auto-cleared-value get when it might not be available"
        )
    }

    override fun setValue(thisRef: ViewGroup, property: KProperty<*>, value: V) {
        mValue = value
    }

}


fun <T : Any> AppCompatActivity.autoCleared() = AutoClearedValue<T>(this)

fun <K : Any> Fragment.autoCleared() = AutoClearedValueForFragment<K>(this)

fun <V : Any> ViewGroup.autoCleared() = AutoClearedValueForViewGroup<V>(this)