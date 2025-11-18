package arboless;

public class MetodosExternos {
    public static int calcularProfundidad (TDAABB ab, int x){
        if (ab.ArbolVacio()) return 0;
        if( ab.Raiz()==x) return 0;
        if (ab.Raiz()<x){
                return (1+calcularProfundidad(ab.HijoDer(),x));
            }
        if (ab.Raiz()>x){
                return (1+calcularProfundidad(ab.HijoIzq(),x));
            }
        return -1;
    }
    public static boolean existeElementoenABB (TDAABB t, int x){
        if (t.ArbolVacio()) return false;
        else if (t.Raiz()==x) return true;
        else if (t.Raiz()>x){
            return (existeElementoenABB(t.HijoDer(),x));
        }
        else {
            return (existeElementoenABB(t.HijoIzq(),x));
        }
    }
    public static boolean sonEquivalentes (TDAABB a, TDAABB b){
        if (a.ArbolVacio()&&b.ArbolVacio()) return true;
        if (a.ArbolVacio()||b.ArbolVacio()) return false;
        if (a.Raiz()!=b.Raiz()) {return false;}
        boolean x= sonEquivalentes(a.HijoIzq(),b.HijoIzq());
        boolean y= sonEquivalentes(a.HijoDer(),b.HijoDer());
        return (x&&y);

    }
    public static void mostrarInOrdenInverso (TDAABB a, int nivel){
        if (!a.ArbolVacio()){
        mostrarInOrdenInverso(a.HijoDer(), nivel+1);
        for(int i=0;i<nivel;i++){
            System.out.print("\t");
            }
        System.out.println(a.Raiz());
        mostrarInOrdenInverso(a.HijoIzq(), nivel+1);

    }
}}
