package ubiquisense.iorx;

import org.junit.Test;

import ubiquisense.iorx.media.fmodex.AudioChannel;
import ubiquisense.iorx.media.fmodex.AudioProject;
import ubiquisense.iorx.media.fmodex.AudioSystem;
import ubiquisense.iorx.media.fmodex.AudioTrack;
import ubiquisense.iorx.media.fmodex.utils.AudioUtils;

public class DSLAudioFmodexTest  {

	@Test
	public void testDSLFmodexAudioCreation()
	{
		
		AudioProject audioProject = AudioUtils.INSTANCE.createAudioProject();
		
		AudioSystem audioSystem = AudioUtils.INSTANCE.createAudioSystem();
		AudioChannel channel = AudioUtils.INSTANCE.createChannel();
		
		AudioTrack track = AudioUtils.INSTANCE.createAudioTrack();
		
		audioProject.getChannels().add(channel);
		audioProject.setSystem(audioSystem);
		audioProject.getTracks().add(track);
	}
	
}
