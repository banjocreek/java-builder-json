package com.banjocreek.riverbed.builder.json.mutable;

import com.banjocreek.riverbed.builder.MutableBuilder;
import com.banjocreek.riverbed.builder.json.JObjectBuilder;

public interface JObj<P> extends JObjectBuilder<JObj<P>>, MutableBuilder<P> {

    JAry<JObj<P>> array(String name);

    JObj<JObj<P>> object(String name);
}
