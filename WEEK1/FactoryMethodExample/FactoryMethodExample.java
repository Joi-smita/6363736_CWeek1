package FactoryMethodExample;
class FactoryMethodExample {

    interface Document {
        void open();
    }

    static class WordDocument implements Document {
        public void open() {
            System.out.println("Word document opened.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("PDF document opened.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Excel document opened.");
        }
    }

    // Factory Abstract Class
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete Factories
    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}