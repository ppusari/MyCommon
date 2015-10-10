package com.ppusari.my.mybatis.db.typehandler;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;


//@MappedJdbcTypes(JdbcType.TIMESTAMP)
@MappedTypes(value = Calendar.class)
public class CalendarTypeHandler implements TypeHandler<Calendar>
{
	@Override
	public void setParameter(PreparedStatement ps, int i, Calendar parameter, JdbcType jdbcType) throws SQLException {
		
		final Calendar calendar = (Calendar)parameter;
		if(calendar == null) {
			ps.setNull(i, Types.TIMESTAMP);
		}
		else if (JdbcType.DATE.equals(jdbcType))
		{
			ps.setDate(i, new Date(calendar.getTimeInMillis()), calendar);
		}
		else if (JdbcType.TIME.equals(jdbcType))
		{
			ps.setTime(i, new Time(calendar.getTimeInMillis()), calendar);
		}
		else if (JdbcType.TIMESTAMP.equals(jdbcType))
		{
			ps.setTimestamp(i, new Timestamp(calendar.getTimeInMillis()), calendar);
		}
		else
		{
			// 무조건 jdbcType == null로 넘어 온다. 그래서 이렇게 처리함.
			ps.setTimestamp(i, new Timestamp(calendar.getTimeInMillis()), calendar);
			//throw new SQLException("The " + this.getClass() + " typehandler can handle only DATE, TIME, TIMESTAMP types not: " + jdbcType);
		}
	}
	
	protected Calendar createCalendar(final Object sqlDate) throws SQLException
	{
		if(sqlDate == null)
			return null;
			
		if (!(sqlDate instanceof java.util.Date))
		{
			throw new SQLException("The following object is not an instance of the java.util.Date: " + sqlDate);
		}

		final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime((java.util.Date) sqlDate);

		return calendar;
	}
	@Override
	public Calendar getResult(ResultSet rs, String columnName) throws SQLException {
		return this.createCalendar(rs.getObject(columnName));
	}
	@Override
	public Calendar getResult(ResultSet rs, int columnIndex) throws SQLException {
		return this.createCalendar(rs.getObject(columnIndex));
	}
	@Override
	public Calendar getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return this.createCalendar(cs.getObject(columnIndex));
	}
}