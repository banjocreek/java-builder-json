package com.banjocreek.riverbed.builder.json.mutable;

import com.banjocreek.riverbed.builder.MutableBuilder;
import com.banjocreek.riverbed.builder.json.JArrayBuilder;

public interface JAry<P> extends JArrayBuilder<JAry<P>>, MutableBuilder<P> {

    JAry<JAry<P>> array();

    JObj<JAry<P>> object();

}
