package MPP1.src.ppp.builderDesignPathern;

public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    //constructor is marked as private, which means that instances of the Computer
    // class can only be created through the associated builder(better control of instance creation)
    //i.e encapsulation
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }
//Since the Computer class does not provide setter methods for its fields, and the constructor
// is private, instances of Computer become immutable once created.
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", GPU='" + GPU + '\'' +
                '}';
    }

    // Builder class for constructing Computer
    public static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;

        public ComputerBuilder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
// Usage of the builder pattern
 class BuilderExample {
    public static void main(String[] args) {

        // Accessing components of the constructed computer
        Computer computer = new Computer.ComputerBuilder("Intel i7", "16GB", "512GB SSD")
                .setGPU("NVIDIA GeForce RTX 3080")
                .build();

        System.out.println(computer);

    }
}



