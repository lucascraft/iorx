/**
 */
package ubiquisense.iorx.comm.http.io;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Comm Cmd</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.sf.smbt.comm.httpcmd.HttpCommCmd#getProperties <em>Properties</em>}</li>
 *   <li>{@link net.sf.smbt.comm.httpcmd.HttpCommCmd#getMethod <em>Method</em>}</li>
 *   <li>{@link net.sf.smbt.comm.httpcmd.HttpCommCmd#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.sf.smbt.comm.httpcmd.HttpcmdPackage#getHttpCommCmd()
 * @model
 * @generated
 */
public interface HttpCommCmd extends ubiquisense.iorx.cmd.Cmd {
	List<Property> getProperties();

	HttpMethod getMethod();

	void setMethod(HttpMethod value);

	String getCommand();

	void setCommand(String value);

} // HttpCommCmd
