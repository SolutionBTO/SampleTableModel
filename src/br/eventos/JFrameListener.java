package br.eventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

/**
 * classe de eventos para form JFrame
 * @author Solutionbto
 *
 */
public class JFrameListener extends WindowAdapter{
    
	private Logger logger=Logger.getLogger(getClass().getSimpleName()); 
	
	@Override
	public void windowActivated(WindowEvent e) {
		logger.info("windowActivated(...) ");
		super.windowActivated(e);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		logger.info("windowOpened(...) ");
		super.windowOpened(e);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		logger.info("windowClosing(...) ");
		super.windowClosing(e);
	}
	
	
	@Override
	public void windowClosed(WindowEvent e) {
		logger.info("windowClosed(...) ");
		super.windowClosed(e);
	}
}
