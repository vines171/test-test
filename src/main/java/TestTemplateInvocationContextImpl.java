import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

import java.util.List;

public final class TestTemplateInvocationContextImpl implements TestTemplateInvocationContext {
    private final List<Exception> extensions;
    private String displayName;

    @Override
    public String getDisplayName(int InvocationIndex) { return displayName + " [" + InvocationIndex + "]";}

//        @Override
//        public List<Extension> getAdditionalExtensions() { return extensions; }

    public TestTemplateInvocationContextImpl(String displayName, List<Exception> extensions) {
        this.displayName = displayName;
        this.extensions = extensions;
    }

}
