class RendererFactory
{
    public RendererFactory(){}

    /** creates and returns a new 'type' renderer according to a given string and a size if needed, if there
     *  is typo mistake, returns null*/

    public Renderer buildRenderer(String type, int size){
            Renderer renderer;
            switch (type.toLowerCase()){
                case "console":
                    renderer=new ConsoleRenderer(size);
                    return renderer;
                case "none":
                    renderer=new VoidRenderer();
                    return renderer;
                default:
                    return null;
            }
    }
}
