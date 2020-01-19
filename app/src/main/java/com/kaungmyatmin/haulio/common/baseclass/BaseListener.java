package com.kaungmyatmin.haulio.common.baseclass;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseListener<ListenerType> {
    private final Set<ListenerType> mListeners = Collections.newSetFromMap(
            new ConcurrentHashMap<ListenerType, Boolean>(1));

    public void registerListener(ListenerType listener) {
        mListeners.add(listener);
    }

    public void unRegisterListener(ListenerType listener) {
        mListeners.remove(listener);
    }

    public Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }


}
