package pl.rspective.voucherify.android.client.module;

import java.util.concurrent.Executor;

import pl.rspective.voucherify.android.client.api.VoucherifyApi;

abstract class AbsModule<A extends BaseModule.Async, R extends BaseModule.Rx> {
    /**
     * Represents platform thread executor
     */
    final Executor executor;

    /**
     * Describes REST API for voucherify
     */
    final VoucherifyApi api;

    /**
     * The type of object used to do async calls
     */
    final A extAsync;

    /**
     * The type of object used to do rx calls
     */
    final R extRxJava;

    /**
     *
     * @param api describes Voucherif REST API
     * @param executor of threads for current platform
     */
    AbsModule(VoucherifyApi api, Executor executor) {
        this.api = api;
        this.executor = executor;

        this.extAsync = createAsyncExtension();
        this.extRxJava = createRxJavaExtension();
    }

    /**
     *
     * @return
     */
    abstract A createAsyncExtension();

    /**
     *
     * @return
     */
    abstract R createRxJavaExtension();

    /**
     * Returns the asynchronous extension of this module.
     */
    public abstract A async();

    /**
     * Returns the RxJava extension of this module.
     */
    public abstract R rx();

}