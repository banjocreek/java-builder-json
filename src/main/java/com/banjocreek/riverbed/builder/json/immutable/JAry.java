package com.banjocreek.riverbed.builder.json.immutable;

import com.banjocreek.riverbed.builder.ImmutableBuilder;
import com.banjocreek.riverbed.builder.json.JArrayBuilder;

public interface JAry<R, P> extends JArrayBuilder<JAry<R, P>>,
        ImmutableBuilder<R, P> {

    JAry<R, JAry<R, P>> array();

    JObj<R, JAry<R, P>> object();

}
