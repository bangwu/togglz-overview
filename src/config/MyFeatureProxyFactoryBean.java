package config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.togglz.spring.proxy.FeatureProxyFactoryBean;

/**
 * User: AKutuzov
 * Date: 9/4/13
 * Time: 4:45 PM
 */
public class MyFeatureProxyFactoryBean extends FeatureProxyFactoryBean implements FactoryBean<Object>, InitializingBean {
    @Override
    public Class<?> getObjectType() {
        try {
            return super.getObjectType();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
