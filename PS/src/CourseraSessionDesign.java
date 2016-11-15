import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CourseraSessionDesign {

	public static void main(String[] args) {
		 long result[] = new long[3];
		 result = getUpcomingSessions(1470096000000L, 2, 1470787200000L);
		 // 1470096000000L,
		 // 1470787200000L
		 System.out.println(Arrays.toString(result));
		 System.out.println("===========================================");
		long specialization_courses[][] = new long[][] { { 1469923200000L, 2, 4 }, { 1469923200000L, 2, 4 } }; // 1470614400000L-monday
																												// 1469923200000L-given
		long enrollment_date = 1470268800000L; // 1470268800000L-given
		System.out.println(
				Arrays.deepToString(getSpecializationSessionSchedule(specialization_courses, enrollment_date)));
	}

	static long[] getUpcomingSessions(long launch_date, int repeat_frequency, long enrollment_date) {
		Date launchDate = new Date(launch_date);
		Date enrollDate = new Date(enrollment_date);

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(launchDate);
		System.out.println(cal.getTime()); 
		int lday = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("Launch Day: " + lday); 

		cal.setTime(enrollDate);
		System.out.println(cal.getTime()); 
		int eday = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("Enroll Day: " + eday); 

		// Case1: Launch & Enroll same as Monday
		if (launchDate.equals(enrollDate) && eday == Calendar.MONDAY) {
			return addToResult(cal, repeat_frequency);
		}
		// Case2: Launch date = Monday
		else if (lday == Calendar.MONDAY) {
			cal.setTime(launchDate);

			if (enrollDate.after(launchDate)) { // Enroll after launch date
				while (cal.getTime().before(enrollDate) && !cal.getTime().equals(enrollDate)) {
					cal.add(Calendar.DAY_OF_YEAR, repeat_frequency * 7);
				}
				return addToResult(cal, repeat_frequency);
			} else { // Enroll before launch date
				return addToResult(cal, repeat_frequency);
			}
		}
		// Case 3: Launch date not Monday
		else if (lday != Calendar.MONDAY) {
			cal.setTime(launchDate);
			// add 1 as below method represent date object which makes while
			// loop work
			cal.add(Calendar.DATE, 1);
			// set calendar to next Monday
			while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
				cal.add(Calendar.DAY_OF_YEAR, 1);

			if (enrollDate.after(cal.getTime())) {
				while (cal.getTime().before(enrollDate) && !cal.getTime().equals(enrollDate)) {
					cal.add(Calendar.DAY_OF_YEAR, repeat_frequency * 7);
				}
				return addToResult(cal, repeat_frequency);
			} else {
				return addToResult(cal, repeat_frequency);
			}
		}

		return null;
	}

	public static long[] addToResult(Calendar cal, int freq) {
		long result[] = new long[3];
		for (int i = 0; i < 3; i++) {
			result[i] = cal.getTime().getTime();
			cal.add(Calendar.DAY_OF_YEAR, freq * 7);
		}
		return result;
	}

	public static long[][] getSpecializationSessionSchedule(long[][] specialization_courses, long enrollment_date) {
		int rows = specialization_courses.length;
		Date launchDate[] = new Date[rows];
		int freq[] = new int[rows];
		int duration[] = new int[rows];
		Date enrollDate = new Date(enrollment_date);

		for (int i = 0; i < rows; i++) {
			launchDate[i] = new Date(specialization_courses[i][0]);
			freq[i] = (int) specialization_courses[i][1];
			duration[i] = (int) specialization_courses[i][2];
		}

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(enrollDate);
		System.out.println(cal.getTime()); 
		int eday = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("Enroll Day: " + eday); 

		cal.setTime(launchDate[0]);
		System.out.println(cal.getTime());
		int lday = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("Launch Day: " + lday); 

		// case1:
		if (launchDate[0].equals(enrollDate) && eday == Calendar.MONDAY) {
			return addToResult1(launchDate, freq, duration, rows, cal.getTime());
		}
		// case2:
		else if (lday == Calendar.MONDAY) {
			if (enrollDate.after(launchDate[0])) { // Enroll after launch date
				while (cal.getTime().before(enrollDate) && !cal.getTime().equals(enrollDate)) {
					cal.add(Calendar.DAY_OF_YEAR, freq[0] * 7);
				}
				return addToResult1(launchDate, freq, duration, rows, cal.getTime());
			} // Enroll before launch date
			else {
				return addToResult1(launchDate, freq, duration, rows, cal.getTime());
			}
		}
		// case3:
		else if (lday != Calendar.MONDAY) {
			cal.add(Calendar.DATE, 1);

			while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
			}
			if (enrollDate.after(cal.getTime())) {
				while (cal.getTime().before(enrollDate) && !cal.getTime().equals(enrollDate)) {
					cal.add(Calendar.DAY_OF_YEAR, freq[0] * 7);
				}
				return addToResult1(launchDate, freq, duration, rows, cal.getTime());
			} else {
				return addToResult1(launchDate, freq, duration, rows, cal.getTime());
			}
		}
		return null;
	}

	private static long[][] addToResult1(Date[] launchDate, int[] freq, int[] duration, int rows, Date currentDate) {
		long result[][] = new long[rows][2];
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		Calendar calTemp = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(currentDate);
		int i = 0;
		while (i < rows) {
			result[i][0] = cal.getTime().getTime();
			cal.add(Calendar.DAY_OF_YEAR, duration[i] * 7);
			result[i][1] = cal.getTime().getTime();
			i++;
			if (i < rows) {
				if (launchDate[i].before(cal.getTime())) {
					calTemp.setTime(launchDate[i]);

					// set course2 launch to next Monday if its not
					if (calTemp.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
						calTemp.add(Calendar.DATE, 1);
						while (calTemp.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
							calTemp.add(Calendar.DAY_OF_YEAR, 1);
						}
					}

					while (calTemp.getTime().before(cal.getTime()) && !calTemp.getTime().equals(cal.getTime())) {
						calTemp.add(Calendar.DAY_OF_YEAR, freq[i] * 7);
					}
					cal.setTime(calTemp.getTime());
				} else if (launchDate[i].after(cal.getTime())) {
					cal.setTime(launchDate[i]);
					if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
						cal.add(Calendar.DATE, 1);
						while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
							cal.add(Calendar.DAY_OF_YEAR, 1);
						}
					}
				}
			}
		}
		return result;
	}

}