package ru.gpb;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

import java.util.List;

public final class TestTemplateInvocationContextImpl implements TestTemplateInvocationContext {
    private final List<Extension> extensions;
    private String displayName;

    public TestTemplateInvocationContextImpl(String displayName, List<Extension> extensions) {
        this.displayName = displayName;
        this.extensions = extensions;
    }


    @Override
    public String getDisplayName(int InvocationIndex) { return displayName + " [" + InvocationIndex + "]";}

    @Override
    public List<Extension> getAdditionalExtensions() { return extensions; }

}
