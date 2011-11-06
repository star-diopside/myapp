package jp.myapp.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

public class PrototypeScopeMetadataResolver implements ScopeMetadataResolver {

    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {

        ScopeMetadata scopeMetadata = new ScopeMetadata();

        scopeMetadata.setScopeName(BeanDefinition.SCOPE_PROTOTYPE);

        return scopeMetadata;
    }
}
