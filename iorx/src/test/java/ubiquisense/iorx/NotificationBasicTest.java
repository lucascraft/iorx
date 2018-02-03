package ubiquisense.iorx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import ubiquisense.iorx.qx.Cmd;
import ubiquisense.iorx.qx.notifications.Add;
import ubiquisense.iorx.qx.notifications.AddMany;
import ubiquisense.iorx.qx.notifications.Notification;
import ubiquisense.iorx.qx.notifications.Remove;
import ubiquisense.iorx.qx.notifications.RemoveMany;
import ubiquisense.iorx.utils.CmdUtil;

public class NotificationBasicTest 
{
	
	@Test
	public void testNotificationBasicCreatyion()
	{
		Cmd cmdToAdd = CmdUtil.INSTANCE.generateRamdomCmd();
		Add<Cmd> add = new Add<Cmd>(cmdToAdd);
		
		assertNotNull(add);
		assertTrue(add.getNotification().equals(Notification.ADD));
		assertNotNull(add.getValue());
		assertEquals(cmdToAdd, add.getValue());

		List<Cmd> mannyCmdToAdd = CmdUtil.INSTANCE.generateRamdomCmd(100);
		AddMany<Cmd> addMany = new AddMany<Cmd>(mannyCmdToAdd);
		
		assertNotNull(addMany);
		assertTrue(addMany.getNotification().equals(Notification.ADD_MANY));
		assertNotNull(addMany.getValue());
		assertEquals(mannyCmdToAdd, addMany.getValue());

		Cmd cmdToRemove = CmdUtil.INSTANCE.generateRamdomCmd();
		Remove<Cmd> remove = new Remove<Cmd>(cmdToRemove);
		
		assertNotNull(remove);
		assertTrue(remove.getNotification().equals(Notification.REMOVE));
		assertNotNull(remove.getValue());
		assertEquals(cmdToRemove, remove.getValue());

		List<Cmd> mannyCmdToRemove = CmdUtil.INSTANCE.generateRamdomCmd(100);
		RemoveMany<Cmd> removeMany = new RemoveMany<Cmd>(mannyCmdToRemove);

		assertNotNull(removeMany);
		assertTrue(removeMany.getNotification().equals(Notification.REMOVE_MANY));
		assertNotNull(removeMany.getValue());
		assertEquals(mannyCmdToRemove, removeMany.getValue());

	}
}
