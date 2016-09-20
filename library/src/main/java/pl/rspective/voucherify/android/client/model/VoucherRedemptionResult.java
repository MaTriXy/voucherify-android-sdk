package pl.rspective.voucherify.android.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;

public class VoucherRedemptionResult {

    /**
     *  An identifier for entity
     */
    private String id;

    /**
     * When the voucher was redeemed
     */
    private Date date;

    /**
     * Type of the operation (redemption or redemption_rollback)
     */
    private String object;

    /**
     * Id of a customer who made this redemption
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * Voucher's consumer tracking id
     */
    @SerializedName("tracking_id")
    private String trackingId;

    /**
     * Original redemption id (present if this entry is a rollback).
     */
    private String redemption;

    /**
     * Reason of the rollback.
     */
    private String reason;

    /**
     * Full voucher data
     */
    private Voucher voucher;

    /**
     * Metadata - whatever you
     */
    private Map<String, Object> metadata;

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getObject() {
        return object;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getRedemption() {
        return redemption;
    }

    public String getReason() {
        return reason;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

}
