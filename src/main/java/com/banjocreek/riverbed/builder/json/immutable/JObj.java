package com.banjocreek.riverbed.builder.json.immutable;

import com.banjocreek.riverbed.builder.ImmutableBuilder;
import com.banjocreek.riverbed.builder.json.JObjectBuilder;

public interface JObj<R, P> extends JObjectBuilder<JObj<R, P>>,
        ImmutableBuilder<R, P> {

    JAry<R, JObj<R, P>> array(String name);

    JObj<R, JObj<R, P>> object(String name);

}
