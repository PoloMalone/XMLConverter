
# XMLConverter

This project allows users to format ".txt" files in given format,

> **P|Carl Gustaf|Bernadotte**\
> **T|0768-101801|08-101801**\
> **A|Drottningholms slott|Stockholm|10001**\
> **F|Victoria|1977**\
> **A|Haga Slott|Stockholm|10002**\
> **F|Carl Philip|1979**\
> **T|0768-101802|08-101802**\
> **P|Barack|Obama**\
> **A|1600 Pennsylvania Avenue|Washington, D.C**

and output an XML file with the information from the ".txt" file...
 
>
> <people>
    <person>
        <firstname>Carl Gustaf</firstname>
        <lastname>Bernadotte</lastname>
        <phone>
            <mobile>0768-101801</mobile>
            <homenumber>08-101801</homenumber>
        </phone>
        <address>
            <street>Drottningholms slott</street>
            <city>Stockholm</city>
            <postalcode>10001</postalcode>
        </address>
        <family>
            <name>Victoria</name>
            <born>1977</born>
            <address>
                <street>Haga Slott</street>
                <city>Stockholm</city>
                <postalcode>10002</postalcode>
            </address>
            <phone>
                <mobile></mobile>
                <homenumber></homenumber>
            </phone>
        </family>
        <family>
            <name>Carl Philip</name>
            <born>1979</born>
            <address>
                <street></street>
                <city></city>
                <postalcode></postalcode>
            </address>
            <phone>
                <mobile>0768-101802</mobile>
                <homenumber>08-101802</homenumber>
            </phone>
        </family>
    </person>
    <person>
        <firstname>Barack</firstname>
        <lastname>Obama</lastname>
        <phone>
            <mobile></mobile>
            <homenumber></homenumber>
        </phone>
        <address>
            <street>1600 Pennsylvania Avenue</street>
            <city>Washington, D.C</city>
            <postalcode></postalcode>
        </address>
    </person>
 </people>


### REQUIREMENTS

* Java
* Maven

### Usage 

> * mvn clean install 
> * mvn exec:java -Dexec.args="PATH_TO_TXT output.xml"  


