package pl.rspective.voucherify.android.client.utils;

import java.util.concurrent.Executor;

import retrofit.android.MainThreadExecutor;

/**
 * Util class to get information about current system platform.
 */
public abstract class Platform {
    /**
     * Current system platfom on which client is running
     */
    private static final Platform PLATFORM = findPlatform();

    /**
     *
     * @return current system platform
     */
    public static Platform get() {
        return PLATFORM;
    }

    /**
     *
     * @return
     */
    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            return new Android();
        } catch (ClassNotFoundException ignored) {
            throw new RuntimeException("SDK is for Android platform");
        }
    }

    /**
     *
     * @return
     */
    public abstract Executor callbackExecutor();

    private static class Android extends Platform {
        /**
         *
         * @return
         */
        @Override
        public Executor callbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    /**
     *
     */
    static class SynchronousExecutor implements Executor {
        /**
         *
         * @param runnable
         */
        @Override
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
}