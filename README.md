# AndroidAppArchitecture

We use MVVM in Android apps.

SOLID principles are the core of our apps.

We use Android architecture components in the apps.

Navigation component is optional, it could be used for small apps.

For injecting dependencies we prefer to use [Koin](https://github.com/InsertKoinIO/koin). It is more lightweight than Dagger2 and it has support for ViewModels. So you don't need to create Factories by yourself when you need to inject something in ViewModel.

Every screen has the following structure:

#### Activity 
  It's just a container for fragments.
   
#### Fragment

It binds viewModel and contains all view logic. 

#### ViewModel

Abstract class for View Model inherited from ViewModel class in AAC.

```kotlin
  abstract class MainViewModel: ViewModel() {
      abstract val list: LiveData<List<Model>>
      abstract fun refresh()
  }
```

It has liveData variables. The main idea is to encapsulate all RxJava in viewModel and provide only liveData to Fragment.


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

It is convenient because you can dispose disposables in onCleared method in ViewModel. Also, it will bring less crashes, etc.  

Thus, every dependency you need in ViewModel is injected.

The crucial point is that all dependencies should have one responsibility and they should be abstractions. 

All Dependencies for ViewModel should be built on principles of Clean Architecture.


