package de.rs.prototype.utils;
import java.text.MessageFormat;
import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;

/**
 * @author tomson <tom.schindl@bestsolution.at>
 * @version $Revision: $
 * @since 1.0
 * 
 */
public class GenericObservableMapLabelProvider extends LabelProvider implements
		ILabelProvider, ITableLabelProvider {
	/**
	 * Template texts
	 */
	private String[] templateTexts;

	/**
	 * The attribute maps
	 */
	private final IObservableMap[] attributeMaps;

	/**
	 * Change listener to track changes
	 */
	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			Set affectedElements = event.diff.getChangedKeys();
			LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
					GenericObservableMapLabelProvider.this, affectedElements.toArray());
			fireLabelProviderChanged(newEvent);
		}
	};

	/**
	 * @param attributeMap
	 * @param templateText 
	 */
	public GenericObservableMapLabelProvider(IObservableMap attributeMap,
			String templateText) {
		this(new IObservableMap[] { attributeMap },
				new String[] { templateText });
	}

	/**
	 * @param attributeMaps
	 * @param templateTexts 
	 */
	public GenericObservableMapLabelProvider(IObservableMap[] attributeMaps,
			String[] templateTexts) {
		this.attributeMaps = attributeMaps;
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
		this.templateTexts = templateTexts;
	}

	public void dispose() {
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].removeMapChangeListener(mapChangeListener);
		}
		super.dispose();
	}

	public Image getImage(Object element) {
		return null;
	}

	public String getText(Object element) {
		return getColumnText(element, 0);
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (columnIndex < templateTexts.length
				&& templateTexts[columnIndex] != null
				&& templateTexts[columnIndex].length() > 0) {
			Object[] elements = new Object[attributeMaps.length];
			for (int i = 0; i < elements.length; i++) {
				elements[i] = attributeMaps[i].get(element);
			}
			return MessageFormat.format(templateTexts[columnIndex], elements);
		} else {
			if (columnIndex < attributeMaps.length) {
				Object result = attributeMaps[columnIndex].get(element);
				return result == null ? "" : result.toString(); //$NON-NLS-1$
			}
		}

		return null;
	}
}