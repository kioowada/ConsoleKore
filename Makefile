all:
	javac Kore.java KoreGame.java NoHandException.java NoPlayerException.java AlreadyOverException.java
	jar -cvf Kore.jar Kore.class KoreGame.class NoHandException.class NoPlayerException.class AlreadyOverException.class

clean:
	rm *.class Kore.jar

