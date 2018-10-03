package org.builder.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * 极光推送-自定义消息
 * 
 * {@link https://docs.jiguang.cn/jpush/server/push/rest_api_v3_push/}
 * 
 * Package : com.yixin.basemessage.dto.jiguang
 * 
 * @author YixinCapital -- zhuqiang 2017年11月14日 下午2:48:55
 *
 */
public class YxJiGuangMessage {

	/**
	 * 
	 * @author YixinCapital -- zhuqiang 2017年11月14日 下午4:26:54
	 *
	 */
	private static final long serialVersionUID = -7402846372805437787L;

	private static final String TITLE = "title";
	private static final String MSG_CONTENT = "msg_content";
	private static final String CONTENT_TYPE = "content_type";
	private static final String EXTRAS = "extras";

	private final String title;
	private final String msgContent;
	private final String contentType;
	private final Map<String, String> extras;
	private final Map<String, Number> numberExtras;
	private final Map<String, Boolean> booleanExtras;

	private YxJiGuangMessage(String title, String msgContent, String contentType, Map<String, String> extras,
			Map<String, Number> numberExtras, Map<String, Boolean> booleanExtras) {
		this.title = title;
		this.msgContent = msgContent;
		this.contentType = contentType;
		this.extras = extras;
		this.numberExtras = numberExtras;
		this.booleanExtras = booleanExtras;
	}

	public String getTitle() {
		return title;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public String getContentType() {
		return contentType;
	}

	public Map<String, String> getExtras() {
		return extras;
	}

	public Map<String, Number> getNumberExtras() {
		return numberExtras;
	}

	public Map<String, Boolean> getBooleanExtras() {
		return booleanExtras;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static YxJiGuangMessage content(String msgContent) {
		return new Builder().setMsgContent(msgContent).build();
	}

	public JsonElement toJSON() {
		JsonObject json = new JsonObject();
		if (null != title) {
			json.add(TITLE, new JsonPrimitive(title));
		}
		if (null != msgContent) {
			json.add(MSG_CONTENT, new JsonPrimitive(msgContent));
		}
		if (null != contentType) {
			json.add(CONTENT_TYPE, new JsonPrimitive(contentType));
		}

		JsonObject extrasObject = null;
		if (null != extras || null != numberExtras || null != booleanExtras) {
			extrasObject = new JsonObject();
		}

		if (null != extras) {
			for (String key : extras.keySet()) {
				if (extras.get(key) != null) {
					extrasObject.add(key, new JsonPrimitive(extras.get(key)));
				} else {
					extrasObject.add(key, JsonNull.INSTANCE);
				}
			}
		}
		if (null != numberExtras) {
			for (String key : numberExtras.keySet()) {
				extrasObject.add(key, new JsonPrimitive(numberExtras.get(key)));
			}
		}
		if (null != booleanExtras) {
			for (String key : booleanExtras.keySet()) {
				extrasObject.add(key, new JsonPrimitive(booleanExtras.get(key)));
			}
		}

		if (null != extras || null != numberExtras || null != booleanExtras) {
			json.add(EXTRAS, extrasObject);
		}

		return json;
	}

	public static class Builder {
		private String title;
		private String msgContent;
		private String contentType;
		private Map<String, String> extrasBuilder;
		private Map<String, Number> numberExtrasBuilder;
		private Map<String, Boolean> booleanExtrasBuilder;

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setMsgContent(String msgContent) {
			this.msgContent = msgContent;
			return this;
		}

		public Builder setContentType(String contentType) {
			this.contentType = contentType;
			return this;
		}

		public Builder addExtra(String key, String value) {
			if (null == extrasBuilder) {
				extrasBuilder = new HashMap<String, String>();
			}
			extrasBuilder.put(key, value);
			return this;
		}

		public Builder addExtras(Map<String, String> extras) {
			if (null == extrasBuilder) {
				extrasBuilder = new HashMap<String, String>();
			}
			for (String key : extras.keySet()) {
				extrasBuilder.put(key, extras.get(key));
			}
			return this;
		}

		public Builder addNumberExtras(Map<String, Number> extras) {
			if (null == extras) {
				numberExtrasBuilder = new HashMap<String, Number>();
			}
			for (Entry<String, Number> entry : extras.entrySet()) {
				numberExtrasBuilder.put(entry.getKey(), entry.getValue());
			}
			return this;
		}

		public Builder addBooleanExtras(Map<String, Boolean> extras) {
			if (null == extras) {
				booleanExtrasBuilder = new HashMap<String, Boolean>();
			}
			for (Entry<String, Boolean> entry : extras.entrySet()) {
				booleanExtrasBuilder.put(entry.getKey(), entry.getValue());
			}
			return this;
		}

		public Builder addExtra(String key, Number value) {
			if (null == numberExtrasBuilder) {
				numberExtrasBuilder = new HashMap<String, Number>();
			}
			numberExtrasBuilder.put(key, value);
			return this;
		}

		public Builder addExtra(String key, Boolean value) {
			if (null == booleanExtrasBuilder) {
				booleanExtrasBuilder = new HashMap<String, Boolean>();
			}
			booleanExtrasBuilder.put(key, value);
			return this;
		}

		public YxJiGuangMessage build() {
			return new YxJiGuangMessage(title, msgContent, contentType, extrasBuilder, numberExtrasBuilder,
					booleanExtrasBuilder);
		}
	}

	public void demo() {
		YxJiGuangMessage yxJiGuangMessage = new YxJiGuangMessage.Builder().setTitle("JPush推送测试-标题")
				.setContentType("JPush推送测试-类型").setMsgContent("JPush推送测试-内容")
				.addExtra("clueId", "2c9280a65de4ea3d015dea04756e01fb").build();
	}
}
