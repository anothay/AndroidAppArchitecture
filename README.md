# AndroidAppArchitecture

We use MVVM in Android apps.

SOLID principles are core of our apps.

We use Android architecture components in apps.

Navigation component is optional, could be used for small apps.

For injecting dependencies we prefer to use [Koin](https://github.com/InsertKoinIO/koin). It is more lightweight than Dagger2, and has support for ViewModels. So you don't need to create Factories by yourself when you need to inject something in ViewModel.

Every screen has the following structure:

- Activity. 
  Just container for frament.
   
- Fragment.

It binds viewModel and contains all view logic. 

- ViewModel

Abstract class for View Model, inherited from ViewModel class in AAC.

```kotlin
  abstract class MainViewModel: ViewModel() {
      abstract val list: LiveData<List<Model>>
      abstract fun refresh()
  }
```

It has liveData variables. Basically idea is to encapsulate all RxJava in viewModel, and provide to Fragment only liveData.


```kotlin

class DefaultMainViewModel(private  var modelLocalRepository: ModelLocalRepository): MainViewModel() {

    override val list: MutableLiveData<List<Model>> = MutableLiveData()

    private  var disposable: Disposable?=null

    init {
        list.postValue(modelLocalRepository.getList())
        observeList()
    }


    private fun observeList() {
        disposable = modelLocalRepository.observeList().subscribe { new ->
            list.postValue(new)
        }
    }

    override fun refresh() {
        val new = Model(UUID.randomUUID().toString(), Date().time.toString())
        modelLocalRepository.save(new)

    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
  }
```

It is convenient because you can dispose disposables in onCleared method in ViewModel, as well it will bring less crashes and etc.  

So every Logic Unit you need in ViewModel is injected.

The very important thing, that all logic units should have one responsibility, and should be abstractions. 

All Units for ViewModel should be built on principles of Clean Architecture.

ViewModel should contains UseCases, or directly abstract repositories if it needs only call to persistence storage, etc;


