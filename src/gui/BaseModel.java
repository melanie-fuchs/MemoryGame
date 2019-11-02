/**
 * 
 */
package gui;

import java.awt.Component;

/**
 * @author yume
 *
 */
public interface BaseModel {
	void action(int hashCodeOfTrigger);
	int getAttempts();
}
