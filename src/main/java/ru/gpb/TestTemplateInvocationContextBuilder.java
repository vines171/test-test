package ru.gpb;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.ArrayList;
import java.util.List;

public final class TestTemplateInvocationContextBuilder {
    private final List<Extension> extensions = new ArrayList<>();
    private String displayName;

    public TestTemplateInvocationContextBuilder withDisplayName(String displayName) {
        this.displayName =  displayName;
        return this;
    }

    public <T> TestTemplateInvocationContextBuilder addParameterResolved(Class<T> parameterType, T value){
        ParameterResolver resolver = new GenericParameterResolver<>(parameterType, value);
        extensions.add(resolver);
        return this;
    }

    public <T> TestTemplateInvocationContextBuilder addParameterResolved(Class<T> parameterType, T value, String parameterName){
        ParameterResolver resolver = new GenericParameterResolver<>(parameterType, value, parameterName);
        extensions.add(resolver);
        return this;
    }

    public TestTemplateInvocationContextBuilder addExtension(Extension extension) {
        extensions.add(extension);
        return this;
    }

    public TestTemplateInvocationContextImpl build() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(displayName);
        return new TestTemplateInvocationContextImpl(stringBuilder.toString(), extensions);
    }
}

