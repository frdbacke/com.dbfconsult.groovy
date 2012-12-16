package com.dbfconsult.inflation

class FetchInflationRates {

	static main(args) {
		def years = 1962..2012;
		def pattern = ~/.*<span id="lbl_inflation_average" style="font-weight:bold;">(\d+\.\d+)&nbsp;%<\/span>.*/

		years.each() {
//			def url = "http://www.inflation.eu/inflation-rates/belgium/historic-inflation/cpi-inflation-belgium-${it}.aspx";
			def url = "http://www.inflation.eu/inflation-rates/the-netherlands/historic-inflation/cpi-inflation-the-netherlands-${it}.aspx";
			
			def data = new URL(url).getText()

			data.eachLine { line ->
				def matcher = pattern.matcher(line);
				if (pattern.matcher(line).matches()) {
					println "${it}," + matcher[0][1]
				}
			}
		}
	}
}
