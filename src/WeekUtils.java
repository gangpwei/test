import java.text.*;import java.util.*;
public class WeekUtils {	
	
	private static int[] WEEKS = new int[]{		
		Calendar.SUNDAY,	
		Calendar.MONDAY,		Calendar.TUESDAY,		
		Calendar.WEDNESDAY,		Calendar.THURSDAY,	
		Calendar.FRIDAY,		Calendar.SATURDAY
		};	
	/** 得到某年第几个星期的日期 */	
	public static Date[] getDatesOfWeek(int year, int weekIndexOfYear){		
		Calendar calendar = Calendar.getInstance();	
		List<Date> list = new ArrayList<Date>();				
		for(int week:WEEKS){			
			calendar.set(Calendar.YEAR, year);			
			calendar.set(Calendar.WEEK_OF_YEAR, weekIndexOfYear);			
			calendar.set(Calendar.DAY_OF_WEEK, week);			
			list.add(calendar.getTime());		
			if(calendar.get(Calendar.YEAR) == year){			
				}		}				
		Collections.sort(list);		
		return list.toArray(new Date[0]);	
	}	
	
	public static Date[] getFirstAndEndDateOfWeek(int year, int weekIndexOfYear){		
		Calendar calendar = Calendar.getInstance();	
		List<Date> list = new ArrayList<Date>();				
		for(int week:WEEKS){			
			calendar.set(Calendar.YEAR, year);			
			calendar.set(Calendar.WEEK_OF_YEAR, weekIndexOfYear);			
			calendar.set(Calendar.DAY_OF_WEEK, week);			
			if(week==calendar.SUNDAY||week==calendar.SATURDAY){
					list.add(calendar.getTime());		
				}	
			}				
		Collections.sort(list);		
		return list.toArray(new Date[0]);	
	}	
	
	/** 得到一个week对象 */	
	public static Week getWeek(Date date){	
		Calendar calendar = Calendar.getInstance();	
		calendar.setTime(date);		
		return new Week(date, calendar.get(Calendar.YEAR), calendar.get(Calendar.WEEK_OF_YEAR));
		}		
	/**字符串转日期 */
	public static Date parseDate(String dateString){		
		try {			
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);		
			} catch (ParseException e) {		
				throw new RuntimeException(e);		
			}	
	}
	/** 日期转字符串 */
	public static String formatDate(Date date){	
		return new SimpleDateFormat("yyyy-MM-dd").format(date);	
	}
	
	public static List<Week> getWeeks(int startYear,int startWeek,int endYear,int endWeek){
		List<Week> list=new ArrayList<Week>();
		try{
			int diff=endWeek-startWeek;
			for (int i = startWeek; i <=endWeek; i++) {
				Date[] dates = getFirstAndEndDateOfWeek(startYear, i);
				Week w=new Week(startYear, i,dates[0], dates[1]);
				list.add(w);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {	
		Calendar calendar = Calendar.getInstance();	
		List<Week> list=getWeeks(2010, 1, 2010, 10);
		for (Week week : list) {
			System.out.println(week);
		}
//		Date[] dates = getFirstAndEndDateOfWeek(2010, 1);
//		//System.out.println("2008年第2个星期是一下几天:");	
//		for(Date date:dates){			
//			System.out.println(formatDate(date));	
//		}				
		//测试方法getWeek		
		//System.out.println(getWeek(parseDate("1900-01-01")));	
	}	
}
