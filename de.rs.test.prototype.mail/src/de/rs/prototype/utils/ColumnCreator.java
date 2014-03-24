package de.rs.prototype.utils;

import java.text.SimpleDateFormat;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;

import de.rs.auxiliary.FormatUtil;
import de.rs.prototype.firdaous.model.WorkOrder;

public class ColumnCreator {
	
	
	


		public static void createColumn(TableViewer tableViewer, String headerText) {
			TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);
			column.getColumn().setWidth(100);
			column.getColumn().setText(headerText);
		
				column.setLabelProvider(new CellLabelProvider() {
					
					@Override
					public void update(ViewerCell cell) {
						WorkOrder order = (WorkOrder)cell.getElement();
						String v = ColumnConstants.RowViewerColumns[cell.getColumnIndex()];
						if("Auftrag Nr".equals(v)){
							
							cell.setText(String.valueOf(order.getProjectId()));
						}
						
						else if("Auftrag Datum".equals(v)){
							String dateStr = FormatUtil.toDateString(order.getWorkOrderDate(), new SimpleDateFormat("dd-MM-yyyy"));
							cell.setText(dateStr);
						}
						else if("Vorname".equals(v)){
							
							cell.setText(order.getPair().getPerson().getFirstname());
						}
						else if("Nachname".equals(v)){
							
							cell.setText(order.getPair().getPerson().getLastname());
						}
						else if("Geburtsdatum".equals(v)){
							String dateStr = FormatUtil.toDateString(order.getPair().getPerson().getBirthday(), new SimpleDateFormat("dd-MM-yyyy"));
							cell.setText(dateStr);
						}
						else if("Sterbedatum".equals(v)){
							String dateStr = FormatUtil.toDateString(order.getPair().getPerson().getDecedDay(), new SimpleDateFormat("dd-MM-yyyy"));
							cell.setText(dateStr);
						}
						else if("Geburtsort".equals(v)){
							
							cell.setText(order.getPair().getPerson().getBirthCity());
						}
						else if("Nationalität".equals(v)){
							String value = order.getPerson().getNationality().getName() != null ? order.getPerson().getNationality().getName() : "";
							cell.setText( value);
						}
						else if("Adresse".equals(v)){
							
							cell.setText(order.getPerson().getAddresse().toString());
						}
						else if("Partner Adresse".equals(v)){
							
							cell.setText(order.getPair().getPartner().getAddresse().toString());
						}
						else if("Partner Vorname".equals(v)){
							
							cell.setText(order.getPair().getPartner().getFirstname());
						}
							
//						} else
//						
//						
//						order.getProjectId();
//						String[] values = (String[]) cell.getElement();
//						String value = values[(cell.getColumnIndex() - 1)];
						//cell.setText(FormatUtil.dbToTimeString(value));
						
					}
				});
				
			
			
			
			
//				
////				column.setLabelProvider(new ColumnLabelProvider() {
////					@Override
////					public String getText(Object element) {
////					  return "TestValue";  // no string representation, we only want to display the image
////					}
////			});
//			}

		}
	}