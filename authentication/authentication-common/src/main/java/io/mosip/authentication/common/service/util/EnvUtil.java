package io.mosip.authentication.common.service.util;

import static io.mosip.authentication.core.constant.IdAuthCommonConstants.DEFAULT_AAD_LAST_BYTES_NUM;
import static io.mosip.authentication.core.constant.IdAuthCommonConstants.DEFAULT_HOST_NAME;
import static io.mosip.authentication.core.constant.IdAuthCommonConstants.DEFAULT_PARTIAL_MATCH_VALUE;
import static io.mosip.authentication.core.constant.IdAuthCommonConstants.DEFAULT_REQUEST_TIME_ADJUSTMENT_SECONDS;
import static io.mosip.authentication.core.constant.IdAuthCommonConstants.DEFAULT_SALT_LAST_BYTES_NUM;
import static io.mosip.authentication.core.constant.IdAuthCommonConstants.KYC;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.ALLOWED_AUTH_TYPE;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.ALLOWED_DOMAIN_URIS;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.ALLOWED_ENVIRONMENTS;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.APPLICATION_ID;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.APPLICATION_NAME;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.AUDIT_DEFAULT_HOST_NAME;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.AUTHREQUEST_RECEIVED_TIME_ADJUSTMENT_IN_SECONDS;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.AUTHREQUEST_RECEIVED_TIME_ALLOWED_IN_SECONDS;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.BIO_SEGMENT_TIME_DIFF_ALLOWED;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.DATE_TIME_PATTERN;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.DELAY_TO_PULL_MISSING_CREDENTIAL_AFTER_TOPIC_SUBACTIPTION;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.EKYC_ALLOWED_AUTH_TYPE;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.FRAUD_ANALYSIS_ENABLED;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.IDA_BIO_HASH_VALIDATION_DISABLED;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.INTERNAL_ALLOWED_AUTH_TYPE;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.INTERNAL_AUTH_ALLOWED_IDTYPE;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.MOSIP_ERRORMESSAGES_DEFAULT_LANG;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.MOSIP_FMR_ENABLED;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.MOSIP_IDTYPE_ALLOWED;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.MOSIP_MANDATORY_LANGUAGES;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.RESPONSE_TOKEN_ENABLE;
import static io.mosip.authentication.core.constant.IdAuthConfigKeyConstants.USER_NAME;
import static io.mosip.idrepository.core.constant.IdRepoConstants.DEFAULT_SALT_KEY_LENGTH;
import static io.mosip.idrepository.core.constant.IdRepoConstants.SALT_KEY_LENGTH;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import io.mosip.authentication.core.constant.IdAuthConfigKeyConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manoj SP
 *
 */
@Component
@EqualsAndHashCode(callSuper=false)
public class EnvUtil extends AbstractEnvironment {

	@Getter @Setter private static String  dateTimePattern;

	@Getter @Setter private static String  allowedAuthType;

	@Getter @Setter private static String  allowedIdTypes;

	@Getter @Setter private static String  internalAllowedAuthType;

	@Getter @Setter private static String  internalAllowedIdTypes;

	@Getter @Setter private static String  ekycAllowedAuthType;
	
	@Getter @Setter private static String  allowedEnv;

	@Getter @Setter private static String  allowedDomainUri;

	@Getter @Setter private static Boolean isFmrEnabled;

	@Getter @Setter private static String  auditDefaultHostName;

	@Getter @Setter private static String  appId;

	@Getter @Setter private static String  appName;

	@Getter @Setter private static String  username;

	@Getter @Setter private static String  mandatoryLanguages;
	
	@Getter @Setter private static String  optionalLanguages;

	@Getter @Setter private static Boolean authTokenRequired;

	@Getter @Setter private static Long bioSegmentTimeDiffAllowed;

	@Getter @Setter private static Long authRequestReceivedTimeAllowedInSeconds;

	@Getter @Setter private static Long requestTimeAdjustmentSeconds;
	
	@Getter @Setter private static Boolean isFraudAnalysisEnabled;

	@Getter @Setter private static Long delayToPullMissingCredAfterTopicSub;
	
	@Getter @Setter private static String  signResponse;
	
	@Getter @Setter private static String  errorMsgDefaultLang;
	
	@Getter @Setter private static String  idaAuthClientId;
	
	@Getter @Setter private static Integer saltKeyLength;
	
	@Getter @Setter private static String  defaultTemplateLang;
	
	@Getter @Setter private static String  userPrefLangAttrName;
	
	@Getter @Setter private static String  internalAuthAllowedType;
	
	@Getter @Setter private static String  authEmailContentTemplate;
	
	@Getter @Setter private static String  authEmailSubjectTemplate;
	
	@Getter @Setter private static String  otpSubjectTemplate;
	
	@Getter @Setter private static String  otpContentTemplate;
	
	@Getter @Setter private static String  authSmsTemplate;
	
	@Getter @Setter private static String  otpSmsTemplate;
	
	@Getter @Setter private static Integer defaultMatchValue;
	
	@Getter @Setter private static String  uinMaskingCharCount;
	
	@Getter @Setter private static String  notificationType;
	
	@Getter @Setter private static Integer otpExpiryTime;
	
	@Getter @Setter private static String  notificationDateFormat;
	
	@Getter @Setter private static String  notificationTimeFormat;
	
	@Getter @Setter private static String  notificationTimeZone;
	
	@Getter @Setter private static String  keySplitter;
	
	@Getter @Setter private static Integer otpRequestFloodingDuration;
	
	@Getter @Setter private static Integer otpRequestFloodingMaxCount;
	
	@Getter @Setter private static Boolean isBioHashValidationDisabled;
	
	@Getter @Setter private static Integer saltLastBytesSum;
	
	@Getter @Setter private static Integer aadLastBytesSum;
	
	@Getter @Setter private static String  partnerBioRefId;

	@Getter @Setter private static String  partnerRefId;

	@Getter @Setter private static String  idaApiIdWithKyc;

	@Getter @Setter private static Boolean internalAuthSigningRequired;

	@Getter @Setter private static Boolean internalAuthSignatureVerificationRequired;

	@Getter @Setter private static Boolean internalAuthTrustValidationRequired;

	@Getter @Setter private static Boolean internalAuthBioHashValidationDisabled;

	@Getter @Setter private static String  internalAuthInternalRefId;

	@Getter @Setter private static String  internalAuthInternalBioRefId;
	
	@Autowired
	private Environment env;

	@PostConstruct
	public void init() {
		this.merge((ConfigurableEnvironment) env);
		setIsFmrEnabled(super.getProperty(MOSIP_FMR_ENABLED, boolean.class, false));
		setAuditDefaultHostName(super.getProperty(AUDIT_DEFAULT_HOST_NAME, DEFAULT_HOST_NAME));
		setDateTimePattern(super.getProperty(DATE_TIME_PATTERN));
		setAllowedAuthType(super.getProperty(ALLOWED_AUTH_TYPE));
		setAllowedIdTypes(super.getProperty(MOSIP_IDTYPE_ALLOWED));
		setInternalAllowedAuthType(super.getProperty(INTERNAL_ALLOWED_AUTH_TYPE));
		setInternalAllowedIdTypes(super.getProperty(INTERNAL_AUTH_ALLOWED_IDTYPE));
		setEkycAllowedAuthType(super.getProperty(EKYC_ALLOWED_AUTH_TYPE));
		setAllowedEnv(super.getProperty(ALLOWED_ENVIRONMENTS));
		setAllowedDomainUri(super.getProperty(ALLOWED_DOMAIN_URIS));
		setAppId(super.getProperty(APPLICATION_ID));
		setAppName(super.getProperty(APPLICATION_NAME));
		setUsername(super.getProperty(USER_NAME));
		setMandatoryLanguages(super.getProperty(MOSIP_MANDATORY_LANGUAGES));
		setOptionalLanguages(super.getProperty(IdAuthConfigKeyConstants.MOSIP_OPTIONAL_LANGUAGES));
		setAuthTokenRequired(super.getProperty(RESPONSE_TOKEN_ENABLE, Boolean.class));
		setBioSegmentTimeDiffAllowed(super.getProperty(BIO_SEGMENT_TIME_DIFF_ALLOWED, Long.class, 120L));
		setAuthRequestReceivedTimeAllowedInSeconds(super.getProperty(AUTHREQUEST_RECEIVED_TIME_ALLOWED_IN_SECONDS,
				Long.class));
		setRequestTimeAdjustmentSeconds(super.getProperty(AUTHREQUEST_RECEIVED_TIME_ADJUSTMENT_IN_SECONDS, Long.class,
				DEFAULT_REQUEST_TIME_ADJUSTMENT_SECONDS));
		setIsFraudAnalysisEnabled(super.getProperty(FRAUD_ANALYSIS_ENABLED, Boolean.class, true));
		setDelayToPullMissingCredAfterTopicSub(super.getProperty(DELAY_TO_PULL_MISSING_CREDENTIAL_AFTER_TOPIC_SUBACTIPTION, Long.class, 60000l));
		setSignResponse(super.getProperty(IdAuthConfigKeyConstants.SIGN_RESPONSE));
		setErrorMsgDefaultLang(super.getProperty(MOSIP_ERRORMESSAGES_DEFAULT_LANG));
		setIdaAuthClientId(super.getProperty(IdAuthConfigKeyConstants.MOSIP_IDA_AUTH_CLIENTID));
		setSaltKeyLength(super.getProperty(SALT_KEY_LENGTH, Integer.class, DEFAULT_SALT_KEY_LENGTH));
		setDefaultTemplateLang(super.getProperty(IdAuthConfigKeyConstants.DEFAULT_TEMPLATE_LANGUAGES));
		setUserPrefLangAttrName(super.getProperty(IdAuthConfigKeyConstants.USER_PREFFRRED_LANG_ATTRIBUTE_NAME));
		setInternalAuthAllowedType(super.getProperty(INTERNAL_ALLOWED_AUTH_TYPE));
		setAuthEmailContentTemplate(super.getProperty(IdAuthConfigKeyConstants.AUTH_EMAIL_CONTENT_TEMPLATE));
		setAuthEmailSubjectTemplate(super.getProperty(IdAuthConfigKeyConstants.AUTH_EMAIL_SUBJECT_TEMPLATE));
		setOtpSubjectTemplate(super.getProperty(IdAuthConfigKeyConstants.OTP_SUBJECT_TEMPLATE));
		setOtpContentTemplate(super.getProperty(IdAuthConfigKeyConstants.OTP_CONTENT_TEMPLATE));
		setAuthSmsTemplate(super.getProperty(IdAuthConfigKeyConstants.AUTH_SMS_TEMPLATE));
		setOtpSmsTemplate(super.getProperty(IdAuthConfigKeyConstants.OTP_SMS_TEMPLATE));
		setDefaultMatchValue(super.getProperty(IdAuthConfigKeyConstants.DEFAULT_MATCH_VALUE, int.class, DEFAULT_PARTIAL_MATCH_VALUE));
		setUinMaskingCharCount(super.getProperty(IdAuthConfigKeyConstants.UIN_MASKING_CHARCOUNT));
		setNotificationType(super.getProperty(IdAuthConfigKeyConstants.MOSIP_NOTIFICATIONTYPE));
		setOtpExpiryTime(super.getProperty(IdAuthConfigKeyConstants.MOSIP_KERNEL_OTP_EXPIRY_TIME, Integer.class));
		setNotificationDateFormat(super.getProperty(IdAuthConfigKeyConstants.NOTIFICATION_DATE_FORMAT));
		setNotificationTimeFormat(super.getProperty(IdAuthConfigKeyConstants.NOTIFICATION_TIME_FORMAT));
		setNotificationTimeZone(super.getProperty(IdAuthConfigKeyConstants.NOTIFICATION_TIME_ZONE));
		setKeySplitter(super.getProperty(IdAuthConfigKeyConstants.KEY_SPLITTER));
		setOtpRequestFloodingDuration(super.getProperty(IdAuthConfigKeyConstants.OTP_REQUEST_FLOODING_DURATION, Integer.class));
		setOtpRequestFloodingMaxCount(super.getProperty(IdAuthConfigKeyConstants.OTP_REQUEST_FLOODING_MAX_COUNT, Integer.class));
		setIsBioHashValidationDisabled(super.getProperty(IDA_BIO_HASH_VALIDATION_DISABLED, Boolean.class, false));
		setInternalAuthBioHashValidationDisabled(super.getProperty(IDA_BIO_HASH_VALIDATION_DISABLED, Boolean.class, true));
		setSaltLastBytesSum(super.getProperty(
				IdAuthConfigKeyConstants.IDA_SALT_LASTBYTES_NUM, Integer.class, DEFAULT_SALT_LAST_BYTES_NUM));
		setAadLastBytesSum(super.getProperty(
				IdAuthConfigKeyConstants.IDA_AAD_LASTBYTES_NUM, Integer.class, DEFAULT_AAD_LAST_BYTES_NUM));
		setPartnerBioRefId(super.getProperty(IdAuthConfigKeyConstants.PARTNER_BIO_REFERENCE_ID));
		setPartnerRefId(super.getProperty(IdAuthConfigKeyConstants.PARTNER_REFERENCE_ID));
		setIdaApiIdWithKyc(super.getProperty(IdAuthConfigKeyConstants.MOSIP_IDA_API_ID + KYC));
		setInternalAuthSigningRequired(super.getProperty("mosip.ida.internal.signing-required", Boolean.class, true));
		setInternalAuthSignatureVerificationRequired(super.getProperty("mosip.ida.internal.signature-verification-required", Boolean.class, false));
		setInternalAuthTrustValidationRequired(super.getProperty("mosip.ida.internal.trust-validation-required", Boolean.class, false));
		setInternalAuthInternalRefId(super.getProperty(IdAuthConfigKeyConstants.INTERNAL_REFERENCE_ID));
		setInternalAuthInternalBioRefId(super.getProperty(IdAuthConfigKeyConstants.INTERNAL_BIO_REFERENCE_ID));
	}
}
