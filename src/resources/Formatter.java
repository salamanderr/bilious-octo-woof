package resources;

import java.text.DecimalFormat;

public class Formatter
{
  /**
   *  Returns <code>s</code> padded with spaces on the left to make
   *  a string of a given width (if <code>s.length() < width</code>).
   *  @param width the (minimal) width of the returned string.
   *  @return s if s.length > width;
   *  otherwise returns s padded with spaces on the left.
   */
  public static String format(String s, int width)
  {
    int padding = width - s.length();
    if (padding > 0)
      s = spaces.substring(0, padding) + s;
    return s;
  }

  /**
   *  Returns <code>ch</code> padded with spaces on the left to make
   *  a string of a given width.
   *  @param width the (minimal) width of the returned string.
   *  @return format(String.valueOf(ch), width).
   */
  public static String format(char ch, int width)
  {
    return format(String.valueOf(ch), width);
  }

  /**
   *  Returns <code>m</code> padded with spaces on the left to make
   *  a string of a given width.
   *  @param width the (minimal) width of the returned string.
   *  @return format(String.valueOf(m), width).
   */
  public static String format(int m, int width)
  {
    return format(String.valueOf(m), width);
  }

  /**
   *  Returns <code>x</code> padded with spaces on the left to make
   *  a string of a given width.
   *  @param width the (minimal) width of the returned string.
   *  @return format(String.valueOf(x), width).
   */
  public static String format(double x, int width)
  {
    return format(String.valueOf(x), width);
  }

  /**
   *  Converts <code>x</code> into a string using
   *  a DecimalFormat with the specified precision.  Returns the resulting
   *  string, padded with spaces on the left to make
   *  a string of a given width.
   *  @param width the (minimal) width of the returned string.
   *  @return the formatted and padded string.
   */
  public static String format(double x, int width, int precision)
  {
    DecimalFormat df;
    if (precision > 0)
      df = new DecimalFormat("0." + zeroes.substring(0, precision));
    else
      df = new DecimalFormat("0");

    return format(df.format(x), width);
  }

  private static final String spaces = 
    "                                                                        ";
  private static final String zeroes = 
    "0000000000000000";
}
