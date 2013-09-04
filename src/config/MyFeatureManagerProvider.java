package config;

import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.cache.CachingStateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.spi.FeatureManagerProvider;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.thread.ThreadLocalUserProvider;

import java.io.File;
import java.io.IOException;

/**
 * User: AKutuzov
 * Date: 9/4/13
 * Time: 3:01 PM
 */
public class MyFeatureManagerProvider implements FeatureManagerProvider {
    private static FeatureManager fm;
    private static final ThreadLocalUserProvider userProvider = new ThreadLocalUserProvider();

    static {
        try {
            fm = new FeatureManagerBuilder()
                    .featureEnum(Features.class)
                    .stateRepository(new FileBasedStateRepository(new File("features.properties")))
                    .userProvider(userProvider)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FeatureManager getFeatureManager() {
        return fm;
    }

    @Override
    public int priority() {
        return 0;
    }

    public static void bind(FeatureUser featureUser) {
        ThreadLocalUserProvider.bind(featureUser);
    }

    public static void release() {
        ThreadLocalUserProvider.release();
    }
}
