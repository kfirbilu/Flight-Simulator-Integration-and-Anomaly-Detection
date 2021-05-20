/*import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class AlgoPluginLoaderImpl implements PluginLoader<TimeSeriesAnomalyDetector> {

    @Override
    public TimeSeriesAnomalyDetector load(String path, String className) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, FileNotFoundException {

        System.out.println("Class directory is: " + path);

        System.out.println("Class name is: " + className);

        // load class directory
        //URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{
        //      new URL("file://" + path)
        //});
        File file = new File(path);


        // Convert File to a URL
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};
        URLClassLoader urlClassLoader = URLClassLoader.newInstance(urls);
        FileInputStream objReader = new FileInputStream(path);
        ClassLoader.getSystemResource();
       ClassLoader.getSystemClassLoader().getResourceAsStream(objReader.toString());
        Class<?> c = urlClassLoader.loadClass(className);

        // return a TimeSeriesAnomalyDetector instance
        return (TimeSeriesAnomalyDetector) c.newInstance();

    }


}*/
