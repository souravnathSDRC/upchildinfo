package org.sdrc.childinfo.util;

import java.util.List;

import org.sdrc.childinfo.model.Error;

public interface StateManager {

	Object getValue(String key);
	void setValue(String Key, Object Value);
	void setError(List<Error> errModels);
	List<Error> getError();

}
