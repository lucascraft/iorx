package ubiquisense.iorx.ui.fx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;

public class NodeAdapter {
	 
    public static NodeAdapter adapt(Object fx) {
        if (fx instanceof Node) {
            return new NodeAdapter((Node)fx);
        } else if (fx instanceof MenuItem) {
            return new NodeAdapter((MenuItem)fx);
        } else if (fx instanceof Tab) {
            return new NodeAdapter((Tab)fx);
        }
        return null;
    }
 
    private Object fxObject;
 
    public NodeAdapter(Node node) {
        this.fxObject = node;
    }
 
    public NodeAdapter(MenuItem menuItem) {
        this.fxObject = menuItem;
    }
 
    public NodeAdapter(Tab tab) {
        this.fxObject = tab;
    }
 
	public List<NodeAdapter> getChildrenUnmodifiable() {
	    List<NodeAdapter> result = new ArrayList<NodeAdapter>();
	 
	    // primary parent type derived from the root type
	    if (fxObject instanceof Parent) {
	        ((Parent)fxObject).getChildrenUnmodifiable().forEach(node -> result.add(new NodeAdapter(node)));
	    } else if (fxObject instanceof Menu) {
	        ((Menu)fxObject).getItems().forEach(item -> result.add(new NodeAdapter(item)));
	    } else if (fxObject instanceof Tab) {
	        Node content = ((Tab)fxObject).getContent();
	        if (content != null)
	            result.add(new NodeAdapter(content));
	    } 
	 
	    // extended parent types
	    if (fxObject instanceof MenuBar) {
	        ((MenuBar)fxObject).getMenus().forEach(menu -> result.add(new NodeAdapter(menu)));
	    } else if (fxObject instanceof TabPane) {
	        ((TabPane)fxObject).getTabs().forEach(tab -> result.add(new NodeAdapter(tab)));
	    } else if (fxObject instanceof TitledPane) {
	        Node content = ((TitledPane)fxObject).getContent();
	        if (content != null)
	            result.add(new NodeAdapter(content));
	    } else if (fxObject instanceof ScrollPane) {
	        Node content = ((ScrollPane)fxObject).getContent();
	        if (content != null)
	            result.add(new NodeAdapter(content));
	    } else if (fxObject instanceof Accordion) {
	        ((Accordion)fxObject).getPanes().forEach(pane -> result.add(new NodeAdapter(pane)));
	    } else if (fxObject instanceof SplitPane) {
	        ((SplitPane)fxObject).getItems().forEach(item -> result.add(new NodeAdapter(item)));
	    } else if (fxObject instanceof ToolBar) {
	        ((ToolBar)fxObject).getItems().forEach(item -> result.add(new NodeAdapter(item)));
	    } else if (fxObject instanceof ButtonBar) {
	        ((ButtonBar)fxObject).getButtons().forEach(button -> result.add(new NodeAdapter(button)));
	    }
	 
	    // context menu
	    if (fxObject instanceof Control) {
	        ContextMenu contextMenu = ((Control)fxObject).getContextMenu();
	        if (contextMenu != null) {
	            contextMenu.getItems().forEach(item -> result.add(new NodeAdapter(item)));
	        }
	    }
	 
	    return Collections.unmodifiableList(result);
	}

 
    public void accept(INodeVisitor visitor) {
        boolean result = visitor.visit(this);
        if (!result)
            return;
        getChildrenUnmodifiable().forEach(nodeAdapter -> nodeAdapter.accept(visitor));
    }
 
}