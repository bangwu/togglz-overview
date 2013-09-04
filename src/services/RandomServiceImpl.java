package services;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * User: AKutuzov
 * Date: 9/4/13
 * Time: 4:08 PM
 */
public class RandomServiceImpl implements RandomService {
    private Random rnd = new Random();
    @Override
    public int random() {
        return rnd.nextInt(100);
    }
}
