# Código de reto 003

[Código](https://github.com/Bruno-MBl/24-25-EDA1/tree/4f94d08c76d97fcbe3045a3da8457933c2fedf6b/entregas/brunoMaciejewski/reto-003)

<div align=center>

![](/images/entregas/masiasManuel/reto003b/README.svg)

</div>

## Ejemplo de uso

```java
        Compressor compressor=new Compressor();

        String zipped=compressor.zip(TO_ZIP);
        String unzipped=compressor.unzip(zipped); 

        System.out.println(TO_ZIP);
        System.out.println(zipped);
        System.out.println(unzipped);
```

## Clases empleadas (vista pública y privada donde corresponda)

|Compressor
|-
String zip(String toZip)
String unzip(String zipped)
**PRIVADOS**
*String generateSegment(int index, char actualChar)*
*String deleteFirstSegment(String zipped) *
*char getNextCharacter(String zipped)*
*int getNextIndex(String zipped)*

|Dictionary
|-
public int getSegmentIndex(String actualSegment)
public void addElement(String actualSegment)
public String getSegmentAt(int index)

|DictionaryElement
|-
DictionaryElement(int index, String actualSegment)
public String getElement()
public int getIndex()
