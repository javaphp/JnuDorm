package cn.jnu.dorm.utils;

import cn.jnu.dorm.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckPrivilege implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// ��ȡ��Ϣ
		User user = (User) ActionContext.getContext().getSession().get("user"); // ��ǰ��¼�û�
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // ��Ӧ��Ȩ��URL

		// ���δ��¼
		if (user == null) {
			if (privUrl.startsWith("/user_login")) { // "/user_loginUI", "/user_login"
				// �����ȥ��¼���ͷ���
				return invocation.invoke();
			} else {
				// �������ȥ��¼����ת����¼ҳ��
				return "loginUI";
			}
		}
		// ����ѵ� ¼�����ж�Ȩ��
		else {
			if (user.hasPrivilegeByUrl(privUrl)) {
				// �����Ȩ�ޣ��ͷ���
				return invocation.invoke();
			} else {
				// ���û��Ȩ�ޣ���ת����ʾҳ��
				return "noPrivilegeError";
			}
		}
	}

}
