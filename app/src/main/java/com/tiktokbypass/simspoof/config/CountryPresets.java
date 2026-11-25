package com.tiktokbypass.simspoof.config;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 地区预设（扩展版）。
 * 注意：res 里的 region_codes / region_names 两个数组必须与这里的顺序和内容完全一致。
 */
public class CountryPresets {

    public static class RegionInfo {
        public final String countryCode;   // 小写 ISO 国家码，如 "us"
        public final String displayName;   // 界面显示名，如 "美国 (T-Mobile)"
        public final String operatorCode;  // MCC+MNC，如 "310260"
        public final String operatorName;  // 运营商名称，如 "T-Mobile"

        public RegionInfo(String countryCode, String displayName,
                          String operatorCode, String operatorName) {
            this.countryCode = countryCode;
            this.displayName = displayName;
            this.operatorCode = operatorCode;
            this.operatorName = operatorName;
        }
    }

    private static final Map<String, RegionInfo> PRESETS = new LinkedHashMap<>();

    private static void add(String code, String zhName, String mccMnc, String operator) {
        PRESETS.put(code, new RegionInfo(code, zhName + " (" + operator + ")", mccMnc, operator));
    }

    static {
        add("us", "美国", "310260", "T-Mobile");
        add("gb", "英国", "23410", "O2 UK");
        add("jp", "日本", "44010", "NTT DOCOMO");
        add("kr", "韩国", "45005", "SK Telecom");
        add("sg", "新加坡", "52501", "SingTel");
        add("de", "德国", "26201", "T-Mobile DE");
        add("hk", "香港", "45400", "CSL Mobile");
        add("tw", "台湾", "46692", "Chunghwa Telecom");
        add("fr", "法国", "20801", "Orange F");
        add("ca", "加拿大", "302720", "Rogers");
        add("au", "澳大利亚", "50501", "Telstra");
        add("nz", "新西兰", "53005", "Spark");
        add("mx", "墨西哥", "334020", "Telcel");
        add("br", "巴西", "72410", "Vivo");
        add("ar", "阿根廷", "722310", "Claro");
        add("cl", "智利", "73001", "Entel");
        add("co", "哥伦比亚", "732101", "Claro");
        add("pe", "秘鲁", "71610", "Claro");
        add("it", "意大利", "22201", "TIM");
        add("es", "西班牙", "21407", "Movistar");
        add("nl", "荷兰", "20408", "KPN");
        add("be", "比利时", "20601", "Proximus");
        add("se", "瑞典", "24001", "Telia");
        add("no", "挪威", "24201", "Telenor");
        add("dk", "丹麦", "23801", "TDC");
        add("fi", "芬兰", "24405", "Elisa");
        add("pl", "波兰", "26003", "Orange");
        add("ie", "爱尔兰", "27201", "Vodafone");
        add("pt", "葡萄牙", "26806", "MEO");
        add("ch", "瑞士", "22801", "Swisscom");
        add("at", "奥地利", "23201", "A1");
        add("gr", "希腊", "20201", "Cosmote");
        add("cz", "捷克", "23001", "T-Mobile CZ");
        add("ro", "罗马尼亚", "22610", "Orange");
        add("ua", "乌克兰", "25503", "Kyivstar");
        add("tr", "土耳其", "28601", "Turkcell");
        add("my", "马来西亚", "50212", "Maxis");
        add("th", "泰国", "52003", "AIS");
        add("id", "印度尼西亚", "51010", "Telkomsel");
        add("ph", "菲律宾", "51502", "Globe");
        add("vn", "越南", "45204", "Viettel");
        add("bd", "孟加拉国", "47001", "Grameenphone");
        add("sa", "沙特阿拉伯", "42001", "STC");
        add("ae", "阿联酋", "42402", "Etisalat");
        add("il", "以色列", "42501", "Partner");
        add("eg", "埃及", "60202", "Vodafone");
        add("za", "南非", "65501", "Vodacom");
        add("ng", "尼日利亚", "62130", "MTN");
        add("ke", "肯尼亚", "63902", "Safaricom");
    }

    public static RegionInfo getRegionInfo(String code) {
        if (code == null) return null;
        return PRESETS.get(code.toLowerCase());
    }

    public static String getCountryIso(String code) {
        RegionInfo info = getRegionInfo(code);
        return info != null ? info.countryCode : "";
    }

    public static String getOperatorCode(String code) {
        RegionInfo info = getRegionInfo(code);
        return info != null ? info.operatorCode : "";
    }

    public static String getOperatorName(String code) {
        RegionInfo info = getRegionInfo(code);
        return info != null ? info.operatorName : "";
    }

    public static String[] getAllCountryCodes() {
        return PRESETS.keySet().toArray(new String[0]);
    }

    public static String[] getAllDisplayNames() {
        String[] names = new String[PRESETS.size()];
        int i = 0;
        for (RegionInfo info : PRESETS.values()) {
            names[i++] = info.displayName;
        }
        return names;
    }
}
