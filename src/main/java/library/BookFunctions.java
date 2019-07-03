package library;

import java.util.*;
import java.util.stream.Collectors;

public class BookFunctions {

    Scanner scanner = new Scanner(System.in);
    BookYearComparator bookYearComparator = new BookYearComparator();

    //    1. Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę.
    public Optional<Book> findBook(List<Book> listOfBooks, final int isbnNumber) {
        Optional<Book> book1 = listOfBooks.stream()
                .filter(book -> book.getIsbnNumber() == isbnNumber)
                .findFirst();
        return book1;
    }

    public Book findBook2(List<Book> listOfBooks, final int isbnNumner) {
        Book newBook = null;

        for (Book someBook : listOfBooks) {
            if (someBook.getIsbnNumber() == isbnNumner) {
                newBook = someBook;
            }
        }
        return newBook;
    }

    //   2. Zwróć dwie ostatnie książki.
    public List<Book> twoLastBook(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .skip(listOfBooks.size() - 2)
                .collect(Collectors.toList());
    }

    public List<Book> twoLastBook2(List<Book> listOfBooks) {
        List<Book> twoBooks = new ArrayList<>();
        Book newBook = null;

        for (int i = listOfBooks.size() - 2; i < listOfBooks.size(); i++) {
            newBook = listOfBooks.get(i);
            twoBooks.add(newBook);
        }
        return twoBooks;
    }

    //    3. Zwróć najwcześniej wydana książkę.
    public Book erlierBook(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .findFirst()
                .get();
    }

    public Book erlierBook2(List<Book> listOfBooks) {
        Book newBook = listOfBooks.get(0);
        for (Book someBook : listOfBooks) {
            if (someBook.getYear() < newBook.getYear()) {
                newBook = someBook;
            }
        }
        return newBook;
    }

    //    4. Zwróć najpóźniej wydana książkę
//    public Book lastBook(List<Book> listOfBooks) {
//        return listOfBooks.stream()
//                .sorted(Comparator.comparing(Book::getYear))
//                .reduce((first, second) -> second)
//                .get();
//    }
    public Book lastBook(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .max(Comparator.comparing(Book::getYear))
                .get();
    }

    public Book lastBook2(List<Book> listOfBooks) {
        Book newBook = listOfBooks.get(0);
        for (Book someBook : listOfBooks) {
            if (someBook.getYear() > newBook.getYear()) {
                newBook = someBook;
            }
        }
        return newBook;
    }
//   public Book erlierBook3 (List<Book> listOfBooks) {
//       //1
//       listOfBooks.stream()
//               .min(bookYearComparator);
//       //2
//       listOfBooks.stream()
//               .min((o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));
//       //3
//       listOfBooks.stream()
//               .min(Comparator.comparingInt(Book::getYear));
//   }

    //    5. Zwróć sumę lat wydania wszystkich książek.
//    public int sumYear(List<Book> listOfBooks) {
//        Integer yearSum = listOfBooks.stream()
//                .map(book -> book.getYear())
//                .collect(Collectors.summingInt(Integer::intValue));
//        return yearSum;
//    }
    public int sumYear(List<Book> listOfBooks) {
        return listOfBooks.stream().mapToInt(book -> book.getYear()).sum();
    }

    public int sumYear2(List<Book> listOfBooks) {
        int yearSum = 0;
        for (int i = 0; i < listOfBooks.size(); i++) {
            yearSum += listOfBooks.get(i).getYear();
        }
        return yearSum;
    }

    //    6. Zwróć liczbę książek wydanych po 2007 roku
    public List<Book> booksAfter2007(List<Book> listOfBooks) {

        return listOfBooks.stream()
                .filter(book -> book.getYear() > 2007)
                .collect(Collectors.toList());
    }

    public List<Book> booksAfter20072(List<Book> listOfBooks) {
        List<Book> booksAfter2017 = new ArrayList<>();
        Book newBook = null;

        for (Book listOfBook : listOfBooks) {
            if (listOfBook.getYear() > 2007) {
                newBook = listOfBook;
                booksAfter2017.add(newBook);
            }
        }
        return booksAfter2017;
    }

    //    7. Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
    public boolean isEveryBookAfter2000(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .allMatch(book -> book.getYear() > 2000);
    }

    public boolean isEveryBookAfter20002(List<Book> listOfBooks) {
        for (Book listOfBook : listOfBooks) {
            if (listOfBook.getYear() > 2000)
                return false;
        }
        return true;
    }

    //    8. Zwróć średni rok wydania książki w naszym katalogu.
//    public int averageYear(List<Book> listOfBooks) {
//        Integer yearSum = listOfBooks.stream()
//                .map(book -> book.getYear())
//                .collect(Collectors.summingInt(Integer::intValue));
//        int yearAvarage = yearSum / listOfBooks.size();
//        return yearAvarage;
//    }
    public int averageYear(List<Book> listOfBooks) {
        String yearSum = listOfBooks.stream().mapToInt(book -> book.getYear()).average().toString();
        return Integer.valueOf(yearSum);
    }

    public int averageYear2(List<Book> listOfBooks) {
        int yearSum = 0;
        int yearAvarage = 0;
        for (int i = 0; i < listOfBooks.size(); i++) {
            yearSum += listOfBooks.get(i).getYear();
        }
        yearAvarage = yearSum / listOfBooks.size();
        return yearAvarage;
    }

    //    9. Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed  2003 rokiem.
    public boolean isEveryBookBeefore2003(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .anyMatch(book -> book.getYear() < 2003);
    }

    public boolean isEveryBookBefore20032(List<Book> listOfBooks) {
        for (Book listOfBook : listOfBooks) {
            if (listOfBook.getYear() < 2003)
                return true;
        }
        return false;
    }

    //    10. Zwróć wszystkie książki, których tytuł zaczyna się od litery “C” i były one wydane po 2007 roku.
    public List<Book> startedByC(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .filter(book -> book.getTitle().toLowerCase().startsWith("c"))
                .filter(book -> book.getYear() > 2007)
                .collect(Collectors.toList());
    }

    public List<Book> startedByC2(List<Book> listOfBooks) {
        List<Book> booksStratByC = new ArrayList<>();
        Book newBook = null;

        for (Book listOfBook : listOfBooks) {
            if (listOfBook.getYear() > 2007 && listOfBook.getTitle().toLowerCase().startsWith("c")) {
                newBook = listOfBook;
                booksStratByC.add(newBook);
            }
        }
        return booksStratByC;
    }

    //    11. Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2.
    public List<Book> bookTitle(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .filter(book -> book.getYear() % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Book> bookTitle2(List<Book> listOfBooks) {
        List<Book> booksTitle = new ArrayList<>();
        Book newBook = null;
        for (Book listOfBook : listOfBooks) {
            if (listOfBook.getYear() % 2 == 0) {
                newBook = listOfBook;
                booksTitle.add(newBook);
            }
        }
        return booksTitle;
    }

    //    12. Zwróć mapę, która będzie miała klucz isbn i wartość obiekt Book (Map<String, Book>).
    public Map<String, Book> booksMap(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .collect(Collectors.toMap(book -> String.valueOf(book.getIsbnNumber()), book -> book));
    }

    public Map<String, Book> booksMap2(List<Book> listOfBooks) {
        Map<String, Book> mapBooks = new HashMap<>();
        String key;
        Book newBook = null;
        for (int i = 0; i < listOfBooks.size(); i++) {
            key = String.valueOf(listOfBooks.get(i).getIsbnNumber());
            newBook = listOfBooks.get(i);
            mapBooks.put(key, newBook);
        }
        return mapBooks;
    }

    //    13. Posortuj książki po roku wydania zaczynając od wydanej najpóźniej.
    public List<Book> startedTillYoungest(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .sorted(Comparator.comparing(Book::getYear).reversed())
                .collect(Collectors.toList());
    }

    public List<Book> startedTillYoungest2(List<Book> listOfBooks) {
        Collections.sort(listOfBooks, Comparator.comparing(Book::getYear).reversed());
        return listOfBooks;
    }

    //    14. Posortuj książki po roku wydania zaczynając od wydanej najwcześniej.
    public List<Book> startedTillOldest(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());
    }

    public List<Book> startedTillOldest2(List<Book> listOfBooks) {
    listOfBooks.sort(Comparator.comparing(Book::getYear));
//    Collections.sort(listOfBooks, Comparator.comparing(Book::getYear));
        return listOfBooks;
    }

    //    15. Podziel listę książek na 3 listy po 2 książki i zwróć z metody. (*) (bez streama)
    public List<List<Book>> listOfBookList(List<Book> listOfBooks) {
        List<List<Book>> finalList = new ArrayList<>();
        List<Book> smallList = new ArrayList<>();

        for (int i = 0; i < listOfBooks.size() - 1; i = i + 2) {
            smallList = listOfBooks.subList(i, i + 2);
            finalList.add(smallList);
        }
        return finalList;
    }

    //    16. Pogrupuj książki po roku wydania. Metoda powinna zwrócić Map<Integer, List<Book>>
    //    gdzie kluczem jest rok wydania a wartością lista książek wydana w tym roku. (*)
    public Map<Integer, List<Book>> listOfYear(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .collect(Collectors.groupingBy(Book::getYear));
    }

    public Map<Integer, List<Book>> listOfYear2(List<Book> listOfBooks) {
        Map<Integer, List<Book>> mapBook = new HashMap<>();
        List<Book> bookList = new ArrayList<>();
        Book newBook = null;

        for (int i = 0; i < listOfBooks.size() - 1; i++) {
            for (int j = 0; j < listOfBooks.size() - 1; j++) {
                if (listOfBooks.get(j).getYear() == listOfBooks.get(j + 1).getYear()) {
                    newBook = listOfBooks.get(j);
                    bookList.add(newBook);
                    mapBook.put(listOfBooks.get(j).getYear(), bookList);

                } else if
                (listOfBooks.get(j).getYear() != listOfBooks.get(j + 1).getYear()) {
                    newBook = listOfBooks.get(j);
                    List<Book> newList = new ArrayList<>();
                    newList.add(newBook);
                    mapBook.put(listOfBooks.get(j).getYear(), newList);
                }
            }
        }
        return mapBook;
    }

    //    17. Podziel książki na te wydane po 2009 roku i pozostałe. Metoda powinna zwrócić Map<Boolean, List<Book>> gdzie kluczem jest boolean oznaczający czy została wydana po 2009 a wartością będą listy książek. (*)
    public Map<Boolean, List<Book>> beforeAndAfrter2009(List<Book> listOfBooks) {
        return listOfBooks.stream()
                .collect(Collectors.groupingBy(book -> book.getYear() > 2009));
    }

    public Map<Boolean, List<Book>> beforeAndAfrter20092(List<Book> listOfBooks) {
        Map<Boolean, List<Book>> mapBook = new HashMap<>();
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (!mapBook.containsKey(listOfBooks.get(i).getYear() > 2009)) {
                List<Book> newList = new ArrayList<>();
                newList.add(listOfBooks.get(i));
                mapBook.put(listOfBooks.get(i).getYear() > 2009, newList);
            } else {
                mapBook.get(listOfBooks.get(i).getYear() > 2009).add(listOfBooks.get(i));
            }
        }
        return mapBook;
    }
}



