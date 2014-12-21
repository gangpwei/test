import java.util.Date;/** * 表示某个日期是第几年的第几个星期 * */
public class Week {
private  int year;	
private  int weekOfYear;	
private  Date date=null;
public  Date firstdate=null;	
public  Date enddate=null;	
public Week(int year, int weekOfYear, Date firstdate, Date enddate) {
	super();
	this.year = year;
	this.weekOfYear = weekOfYear;
	this.firstdate = firstdate;
	this.enddate = enddate;
}
public Date getFirstdate() {
	return firstdate;
}
public void setFirstdate(Date firstdate) {
	this.firstdate = firstdate;
}
public Date getEnddate() {
	return enddate;
}
public void setEnddate(Date enddate) {
	this.enddate = enddate;
}
public Week(Date date, int year, int weekOfYear) {	
	super();	
	this.date = date;	
	this.year = year;		
	this.weekOfYear = weekOfYear;
	}	
	public int getYear() {		
		return year;	
	}
	public int getWeekOfYear() {	
		return weekOfYear;
	}		
	public Date getDate(){	
		return date;	
	}	
	@Override	
	public String toString() {	
		return "[" + year + "]年第[" + weekOfYear + "]周"+" "+WeekUtils.formatDate(firstdate)+"  "+WeekUtils.formatDate(enddate);
		//return "[" + WeekUtils.formatDate(date) + "]是[" + year + "]年第[" + weekOfYear + "]周";	
	}	
	
}
