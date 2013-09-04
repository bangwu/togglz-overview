package services;

import org.springframework.stereotype.Service;

/**
 * User: AKutuzov
 * Date: 9/4/13
 * Time: 4:08 PM
 */
public class RandomCachedServiceImpl implements RandomService {
    @Override
    public int random() {
        return 42;
    }
}
