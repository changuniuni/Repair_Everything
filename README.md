# Repair Everything!

## Benchmark
Correct/Incorrect patches presented by the ICSE 2018 paper   
* "Identifying Patch Correctness in Test-Based Program Repair" Yingfei Xiong, Xinyuan Liu, Muhan Zeng, Lu Zhang, Gang Huang, ICSE 2018 [[download]](https://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=8453152)

###
!! Please summarize the statistics!!
!! Project, # of correct patches, # of incorrect patches !!

| Project name    || jGenprog                   || jKali          || Nopol2015          ||Nopol2017||ACS      ||HDRepair||Total(Generated)||Developer Patches|  
|                 ||----------------------------||----------------||--------------------||---------||---------||--------||----------------||-----------------|  
|                 || P    |     C     |    I    || P|C|I          || P|C|I	        || P|C|I   || P|C|I   || P|C|I  || P|C|I          || P|C|I           |  
|-----------------||----------------------------||----------------||--------------------||---------||---------||--------||----------------||-----------------|  
| Chart           || 6    |     0     |    6    || 6   |  0  | 6  ||  6|1|5             || 6|0|6   ||2|2|0    ||0|0|0   ||26|3|23         ||25|25|0          |  
| Lang            || 0    |     0     |    0    || 0   |  0  | 0  || 7|3|4              || 4|0|4   ||3|1|2    ||1|0|1   ||15|4|11         ||58|58|0          |  
| Math            || 14   |     5     |    9    || 10  |  1  | 9  || 15|1|14            ||22|0||22 ||15|11|4  ||7|2|5   ||83|20|63        ||84|84|0          |  
| Time            || 2    |     0     |    2    || 2   |  0  | 2  || 1|0|1              || 8|0|8   ||1|1|0    ||1|1|0   ||15|2|13         ||27|27|0          |  

\* P = Patches, C = Correct Patches, I = Incorrect Patches



| Identifier      || Project name               | Number of bugs | Active bug ids      | Deprecated bug ids (\*) |
|-----------------|----------------------------|---------------:|---------------------|-------------------------|
| Chart           | jfreechart                 |       26       | 1-26                | None                    |
| Cli             | commons-cli                |       39       | 1-5,7-40            | 6                       |
| Closure         | closure-compiler           |      174       | 1-62,64-92,94-176   | 63,93                   |
| Codec           | commons-codec              |       18       | 1-18                | None                    |
| Collections     | commons-collections        |        4       | 25-28               | 1-24                    |
| Compress        | commons-compress           |       47       | 1-47                | None                    |
| Csv             | commons-csv                |       16       | 1-16                | None                    |
| Gson            | gson                       |       18       | 1-18                | None                    |
| JacksonCore     | jackson-core               |       26       | 1-26                | None                    |
| JacksonDatabind | jackson-databind           |      112       | 1-112               | None                    |
| JacksonXml      | jackson-dataformat-xml     |        6       | 1-6                 | None                    |
| Jsoup           | jsoup                      |       93       | 1-93                | None                    |
| JxPath          | commons-jxpath             |       22       | 1-22                | None                    |
| Lang            | commons-lang               |       64       | 1,3-65              | 2                       |
| Math            | commons-math               |      106       | 1-106               | None                    |
| Mockito         | mockito                    |       38       | 1-38                | None                    |
| Time            | joda-time                  |       26       | 1-20,22-27          | 21                      |
