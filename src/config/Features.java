package config;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.context.FeatureContext;

/**
 * User: AKutuzov
 * Date: 9/4/13
 * Time: 2:33 PM
 */
public enum Features implements Feature {
    @EnabledByDefault LOGIN,
    RANDOM,
    CACHED_RANDOM,
    DISABLED;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
