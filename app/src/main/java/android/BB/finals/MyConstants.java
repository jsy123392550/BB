package android.BB.finals;

public class MyConstants {
    //���App��Log��TAG
	public static final String APP_TAG = "BB";
	public static final String WEB_SEPARATOR = "/";
    //������ַ
	public static final String HOST = "113.250.153.193:8088" + WEB_SEPARATOR
			+ "web_1" + WEB_SEPARATOR;
	public static final String HTTP = "http://";
    // ��������ַ
	public static final String SERVER_URL = HTTP + HOST;
    // app��ŵ�ַ
	public static final String APP_PATH = WEB_SEPARATOR + "BB";
    // �����ŵ�ַ
	public static final String CACHE_PATH = APP_PATH + WEB_SEPARATOR + "cache";
    // ͼƬ��ŵ�ַ
	public static final String IMAGE_PATH = APP_PATH + WEB_SEPARATOR + "image";
	//����ΪUI�������ֶ���
	public static final String TEXT_USER="�û�";
	public static final String TEXT_NO_NET = "��ǰû������";
	public static final String TEXT_UNKNOWN_EXCEPTION="����δ֪����";
	public static final String TEXT_LOGIN_PWD_WRONG="�û������������";
	public static final String TEXT_NULL="";
    //��������Ӧ��������ɹ���״̬��
	public static final int RESPONSE_CODE_SUCCESS=666;
    //��������Ӧ�������ʧ�ܵ�״̬��
	public static final int RESPONSE_CODE_FAILURE=667;
    //��������Ӧ�������δ֪�����״̬��
	public static final int RESPONSE_CODE_UNKNOWN=668;
    //����Ϊȫ��ʹ�õ��ֶ���
	public static final String KEY_STATE="state";
	public static final String KEY_DATA="data";
	/*����Ϊģ����*/
	public static final String MODULE_NEAR="����";
	public static final String MODULE_ME="��";
	public static final String MODULE_LINKMAN="��ϵ��";
	public static final String MODULE_NEWS="��Ϣ";
	//���·���ʹ�õ��ֶ���
	/*User����ֶ���*/
	public static final String KEY_USER_ID="bb_num";
	public static final String KEY_USER_USERNAME="username";
	public static final String KEY_USER_HEADPHOTO="head_photo";
	public static final String KEY_USER_PERSIGN="personal_sign";
	public static final String KEY_USER_LABEL="label";
	public static final String KEY_USER_LEVEL="credit_level";
	public static final String KEY_USER_MONEY="money";
	public static final String KEY_USER_SESSION="session_id";
	public static final String KEY_USER_LOCATION="location";
	public static final String KEY_USER_SEX="sex";
	/*Information����ֶ���*/
	public static final String KEY_INFORMATION_ID="info_id";
	public static final String KEY_INFORMATION_CONTENT="content";
	public static final String KEY_INFORMATION_TITLE="title";
	public static final String KEY_INFORMATION_LOCATION="location";
	public static final String KEY_INFORMATION_TIME="time";
	public static final String KEY_INFORMATION_MONEY="money";
	public static final String KEY_INFORMATION_BB_ID="bb_num";
	//����Ϊ������
	public static final String METHOD_LOGIN="login";
}
