package com.kaungmyatmin.haulio.errorhandler;


import com.kaungmyatmin.haulio.R;

public enum ErrorType {

    NETWORK_ERROR(R.string.check_your_network_connection),

    TERMS_AND_CONDITIONS_UNCHECK_ERROR(R.string.agree_terms_and_conditions),

    UNAUTHORIZED(R.string.log_in_again),

    COMMENT_UPLOAD_FAIL(R.string.error_comment_upload_fail),

    STORAGE_ERROR(R.string.error_storage_unavailable),

    FILE_NOT_FOUND(R.string.error_file_not_found),

    FILE_NOT_EXIST_IN_DATABASE(R.string.file_exist_only_in_storage),

    DATA_NOT_READY(R.string.error_data_not_ready),

    PROFILE_UPLOAD_FAIL(R.string.error_profile_upload_fail),
    REQUIRED_FIELD_MISSING(R.string.error_required_field_missing);

    private int mResId;

    ErrorType(int resId) {
        mResId = resId;
    }

    public int getStringResId() {
        return mResId;
    }
}
