package io.voucherify.android.view;

import io.voucherify.android.client.exception.VoucherifyError;
import io.voucherify.android.client.model.VoucherResponse;

public interface OnValidatedListener {

    /**
     * Called when validation ended with successful result.
     */
    void onValid(VoucherResponse result);

    /**
     * Called when provided voucher code was invalid (inactive, expired or not-existent).
     */
    void onInvalid(VoucherResponse result);

    /**
     * Called when couldn't get validation result.
     * For example if API keys are invalid.
     */
    void onError(VoucherifyError error);
}
